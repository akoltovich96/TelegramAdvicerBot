# TelegramAdvicerBot
***
Запуск через класс Application или через командную строку с помощью команды mvn spring-boot:run
***
bot.api-key=1071206994:AAFnJcLAt9TDW0gtmmxh1Sua54nJVgSDHFI
---
bot.username=TravelAssistantToReslivBot
***
http://localhost:8080/city/add - тело запроса в виде json(прим.{"name":"Moscow"})
---
http://localhost:8080/city/update/{id} тело запроса в виде текста(прим. Moscow)
---
http://localhost:8080/advice/add/{name} тело запроса в виде текста(прим. New advice)
---
http://localhost:8080//advice/update/{id} тело запроса в виде текста(прим.New advice)
