Запуск selenoid:
cm.exe selenoid start --vnc --browsers "chrome;firefox" --last-versions 2 --args "-limit 4" --force

Запуск тестов:
mvn clean test -Dbrowser=firefox