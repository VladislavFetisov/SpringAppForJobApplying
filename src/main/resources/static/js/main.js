$('#getUsers').click(function () {
    $.ajax({
        url: '/admin/clients', //here is your URL
        type: 'POST',
        success: function (data) {
            const arr = Array.from(data);
            output = $('#main-output')
            output.empty()
            fillOutput(arr)
        },
        error: function (e) {

        }
    });
})
$('#getRequests').click(function () {
    $.ajax({
        url: '/admin/requests', //here is your URL
        type: 'POST',
        success: function (data) {
            output = $('#main-output')
            output.empty()
            const arr = Array.from(data);
            for (var i in arr) {
                var obj = arr[i]
                if (obj.decision === "APPROVED") {
                    output.append("<div>" + "Номер заявки: " + obj.requestId + " Решение: " + obj.decision +
                        " Сумма кредита: " + obj.loanSum + " Срок(в месяцах): " + obj.monthsAmount +
                        " Имя клиента: " + obj.clientName + " Фамилия: " + obj.clientSurname + " Отчество: " +
                        obj.clientMiddleName + "</div>")
                } else {
                    output.append("<div>" + "Номер заявки: " + obj.requestId + " Решение: " + obj.decision
                        + " Имя клиента: " + obj.clientName + " Фамилия: " + obj.clientSurname + " Отчество: " +
                        obj.clientMiddleName + "</div>")
                }

            }
        },
        error: function (e) {

        }
    });

})
$('#getContracts').click(function () {
    $.ajax({
        url: '/admin/contracts', //here is your URL
        type: 'POST',
        success: function (data) {
            const arr = Array.from(data);
            output = $('#main-output')
            output.empty()
            for (var i in arr) {
                var obj = arr[i]
                output.append("<div>" + " Номер договора: " + obj.contractId
                    + " Статус: " + obj.status + " Сумма кредита: " + obj.loanSum + " Срок(в месяцах): " + obj.monthsAmount +
                    " Имя клиента: " + obj.clientName + " Фамилия: " + obj.clientSurname + " Отчество: " +
                    obj.clientMiddleName + "</div>")
            }
        },
        error: function (e) {

        }
    });
})
$('#AllParametersSearch').click(function () {
    const input = $('#AllParametersInput').val()
    const arr = input.split(" ")
    let add = '';
    if (arr[0].match(/[0-9]+/)) {
        if (arr.length === 1)
            add = 'search/telephone'
        else add = 'search/passport'
    } else add = 'search/fullName'
    $.ajax({
        url: '/admin/' + add, //here is your URL
        data: {text: input},
        type: 'POST',
        success: function (data) {
            output = $('#main-output')
            output.empty()
            const arr = Array.from(data);
            fillOutput(arr)
        },
        error: function (e) {

        }
    });
})

function fillOutput(arr) {
    if (arr.length !== 0) {
        for (var i in arr) {
            var obj = arr[i]
            output.append("<div> Фамилия: " + obj.surname + " Имя: "
                + obj.name + " Отчество: " +
                obj.middleName + " Телефон: " + obj.telephoneNumber + " Серия: " + obj.passportSeries +
                " Номер:" + obj.passportNumber + " паспорта</div>")
        }
    } else output.append("<div>Такого пользователя нет в системе</div>")
}