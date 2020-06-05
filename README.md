# intechtask
Task from Intech
Задание

Необходимо реализовать сервис сообщений Pub-Sub
Структура 

●	Описание

●	Протокол Сообщений

●	Модуль Publisher 

●	Модуль Subscriber 

●	Требования

Описание

Необходимо реализовать сервис, состоящий из 2 приложений. Первое приложение publisher отвечает за генерацию и отправку сообщения подписчику (subscriber). Subscriber разбирает сообщение и по определенной логике записывает его в базу данных.

Протокол
Publisher и subscriber общаются между собой методом отправки JSON сообщений по следующему протоколу:

•	Msisdn. Уникальный номер абонента. В рамках этого задания рандомно сгенерированное цифровое значние.
•	Action. Тип сообщения. Сообщения могут быть 2 типов – PURCHASE или SUBSCRIPTION. Значение выбирается рандомно при генерации сообщения.
•	Timestamp. UNIX timestamp.

Пример сообщения:
{
    "msisdn": 123456789,
    "action": "PURCHASE",
    "timestamp": 1589464122
}




Publisher

●	Имеет модуль генерации описанных выше сообщений.

●	Имеет модуль отправки сгенерированных сообщений. Отправка сообщений осуществляется по протоколу HTTP по средствам POST запросов на Subscriber. 

Subscriber 

●	Принимает отправленные запросы по HTTP протоколу.

●	Осуществляет парсинг сообщений.

●	Сохраняет полученные данные в БД

●	ACTION purchase должен сохраняться в таблицу PURCHASE, а ACTION  subscription в таблицу SUBSCRIPTION

Общие требования: 

●	Использование JAVA, Spring(модули на ваше усмотрение)

●	Все данные хранятся в БД (предпочтительно Postgres) 

●	Наличие текстового логгирования 

●	После реализации необходимо предоставить: 

●	Исходный код (архив с проектом или ссылку в github) 

●	Внешние конфигурационные файлы (если используются) 

●	Схему БД (sql) 