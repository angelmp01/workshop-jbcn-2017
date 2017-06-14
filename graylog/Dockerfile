FROM graylog2/server:latest
COPY udp-input-graylog.json /usr/share/graylog/data/contentpacks
ENV GRAYLOG_CONTENT_PACKS_AUTO_LOAD udp-input-graylog.json
ENV GRAYLOG_CONTENT_PACKS_LOADER_ENABLED true
ENV GRAYLOG_CONTENT_PACKS_DIR data/contentpacks
ENV GRAYLOG_PASSWORD_SECRET somepasswordpepper
ENV GRAYLOG_ROOT_PASSWORD_SHA2 8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918
ENV GRAYLOG_WEB_ENDPOINT_URI http://127.0.0.1:9000/api/