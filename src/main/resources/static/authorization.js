const loginInput = document.getElementById('login');
const lengthError = document.getElementById('lengthError');
const formatError = document.getElementById('formatError');

loginInput.addEventListener('input', function() {
    const loginValue = this.value.trim();
    const loginLength = loginValue.length;
    const loginPattern = /^[a-zA-Z0-9]*$/;

    // Проверяем длину ввода
    if (loginLength > 15) {
        lengthError.style.display = 'block';
    } else {
        lengthError.style.display = 'none';
    }

    // Проверяем формат ввода
    if (!loginPattern.test(loginValue)) {
        formatError.style.display = 'block';
    } else {
        formatError.style.display = 'none';
    }
});

const passwordInput = document.getElementById('password');
const lengthErrorMessage = document.getElementById('lengthErrorMessage');
const formatErrorMessage = document.getElementById('formatErrorMessage');

passwordInput.addEventListener('input', function() {
    const passwordValue = this.value.trim();
    const maxLength = 30;
    const lengthPattern = new RegExp(`^.{0,${maxLength}}$`);
    const formatPattern = /^[a-zA-Z0-9!@#%^&*-+]*$/;

    // Проверка максимальной длины пароля
    if (!lengthPattern.test(passwordValue)) {
        lengthErrorMessage.style.display = 'block';
    } else {
        lengthErrorMessage.style.display = 'none';
    }

    // Проверка разрешенных символов пароля
    if (!formatPattern.test(passwordValue)) {
        formatErrorMessage.style.display = 'block';
    } else {
        formatErrorMessage.style.display = 'none';
    }
});


// document.addEventListener("DOMContentLoaded", function() {
//     var loginButton = document.getElementById("loginButton");
//
//     loginButton.addEventListener("click", function() {
//         // Переход на страницу main.html
//         window.location.href = "main.html";
//     });
// });
