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
$('#fullNameSearch').click(function () {
    $.ajax({
        url: '/admin/search/fullName', //here is your URL
        data: {text: $('#fullNameInput').val()},
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
$('#telephoneSearch').click(function () {
    $.ajax({
        url: '/admin/search/telephone', //here is your URL
        data: {text: $('#telephoneInput').val()},
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
$('#passportSearch').click(function () {
    $.ajax({
        url: '/admin/search/passport', //here is your URL
        data: {text: $('#passportInput').val()},
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
function fillOutput(arr){
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