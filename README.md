# Приложение-APM для менеджера
Функционал состоит из  возможности подачи заявки на кредит, подписания договора,также реализована возможностью поиска.
По ссылек /creditRequest менеджер может заполнить форму(заявку) на получения кредита для пользователя, также этот пользователь автоматически заносится в базу данных(таблица clients) вместе с заявкой(таблица requests).
Далее система с помощью методов машинного обучения решает стоит ли давать кредит данному клиенту или нет(в данной реализации семейное положение клиента играет решающую роль:))
Если заявка успешно подтверждена, то пользователя автоматически переходит на страницу /contract где он может ознакомиться с кредитным договором и решить,
подписывать его или нет, также все виды договоров заносятся в базу данных(таблица contracts).

Переходя по ссылку /admin вам предоставляются разные методы поиска клиентов,договоров, заявок.Особое внимание хочу обратить на поиск:
в данной реализации можно искать по фамилии, по фамилии и имени, по фамилии, имени и отчеству, по номеру телефона или по данным паспорта(изложенный порядок слов в запросе должен соблюдаться.Пример запроса(fetis Vlad)-найдет существующего пользователя в базе: Fetisov Vladislav...

Также нет необходимости подключать базу данных, так как она уже лежит на сервере(см. application properties).
