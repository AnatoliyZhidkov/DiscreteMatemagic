// // Функция проверки логина
// function isLoginValid(login) {
//     // Регулярное выражение для логина: буквы латинского алфавита, цифры и точка
//     const loginRegex = /^[A-Za-z0-9.]+$/;
//     return loginRegex.test(login);
// }
//
// // Функция проверки пароля
// function isPasswordValid(password) {
//     // Регулярное выражение для пароля: минимум 8 символов, заглавная и строчная буквы, цифра и спецсимвол
//     const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
//     return passwordRegex.test(password);
// }
//
// // Функция для отображения ошибки
// function showError(element) {
//     element.style.opacity = '1';
//     element.style.transform = 'translateY(0)';
//     element.style.maxHeight = '100px'; // Достаточное значение, чтобы вмещать содержимое
// }
//
// // Функция для скрытия ошибки
// function hideError(element) {
//     element.style.opacity = '0';
//     element.style.transform = 'translateY(20px)';
//     element.style.maxHeight = '0';
// }
//
// // Функция для проверки и отображения ошибок
// function validateLogin() {
//     const login = document.getElementById('login').value;
//     const lengthError = document.getElementById('lengthError');
//     const formatError = document.getElementById('formatError');
//
//     // Скрываем сообщения об ошибках
//     hideError(lengthError);
//     hideError(formatError);
//
//     // Проверяем логин
//     let isValid = true;
//     if (login.length > 30) {
//         showError(lengthError);
//         isValid = false;
//     }
//     if (!isLoginValid(login)) {
//         showError(formatError);
//         isValid = false;
//     }
//
//     return isValid;
// }
//
// function validatePassword() {
//     const password = document.getElementById('password').value;
//     const lengthErrorMessage = document.getElementById('lengthErrorMessage');
//     const formatErrorMessage = document.getElementById('formatErrorMessage');
//
//     // Скрываем сообщения об ошибках
//     hideError(lengthErrorMessage);
//     hideError(formatErrorMessage);
//
//     // Проверяем пароль
//     let isValid = true;
//     if (password.length > 30) {
//         showError(lengthErrorMessage);
//         isValid = false;
//     }
//     if (!isPasswordValid(password)) {
//         showError(formatErrorMessage);
//         isValid = false;
//     }
//
//     return isValid;
// }
//
// function validateAndRedirect() {
//     const isLoginCorrect = validateLogin();
//     const isPasswordCorrect = validatePassword();
//
//     // Если оба поля валидны, перенаправляем на main.html
//     if (isLoginCorrect && isPasswordCorrect) {
//         window.location.href = "main.html";
//     }
// }
//
// // Добавляем обработчики событий для полей ввода
// document.getElementById('login').addEventListener('input', validateLogin);
// document.getElementById('password').addEventListener('input', validatePassword);
//
// // Добавляем обработчик события для кнопки входа
// document.getElementById('loginButton').addEventListener('click', function(event) {
//     event.preventDefault(); // Предотвращаем отправку формы по умолчанию
//     validateAndRedirect();
// });


// Получаем ссылку на элементы
var forgotPasswordLink = document.getElementById("forgotPassword");

// Показываем alert при клике на "Забыли пароль?"
forgotPasswordLink.addEventListener("click", function() {
    alert("Если вы забыли свой пароль, пожалуйста, обратитесь к вашему преподавателю для его замены. Он сможет помочь вам восстановить доступ к вашей учетной записи");
});


//просмотр пароля
$('body').on('click', '.password-control', function(){
    if ($('#password').attr('type') == 'password') {
        $(this).text('Скрыть пароль');
        $('#password').attr('type', 'text');
    } else {
        $(this).text('Показать пароль');
        $('#password').attr('type', 'password');
    }
    return false;
});