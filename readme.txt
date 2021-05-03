Проект содержит тесты для https://events.epam.com/

Настроен автоматический запуск job в Jenkins:
- по push новых изменений в git-репозиторий

Для локального проксирования Jenkins и работы webHook используется:
https://ngrok.com/

После прогонки тестов:
- происходит архивация артефактов
- генерируются Allure отчеты
- происходит отправка уведомления в Slack-канал

Уведомления содержат в себе:
- статус сборки
- название job в Jenkins
- номер билда
- время выполнения job
- количество тестов (всего / упавших / пропущенных / пройденных)
- ссылку на job

Запуск selenoid:
cm.exe selenoid start --vnc --browsers "chrome;firefox" --last-versions 2 --args "-limit 4" --force

Запуск тестов:
mvn clean test -Dbrowser=firefox