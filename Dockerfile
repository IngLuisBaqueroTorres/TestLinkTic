FROM amazoncorretto:11-alpine3.17 AS development

RUN apk update && apk add --no-cache inotify-tools supervisor

ENV APP=/app

RUN mkdir -p $APP

WORKDIR $APP

COPY build.gradle settings.gradle gradlew $APP

COPY gradle $APP/gradle

RUN ./gradlew --version || return 0

COPY .. .

RUN ./gradlew --version

COPY docker/supervisord.conf /etc/supervisor/conf.d/supervisord.conf

CMD /usr/bin/supervisord -c /etc/supervisor/conf.d/supervisord.conf

