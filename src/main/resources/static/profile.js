// Функция для проверки валидности пароля
function isPasswordValid(password) {
    // Регулярное выражение для проверки пароля: минимум 8 символов, заглавная и строчная буквы, цифра и спецсимвол
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordRegex.test(password);
}

// Функция для отображения ошибки
function showError(element, message) {
    element.textContent = message;
    element.style.opacity = '1';
    element.style.transform = 'translateY(0)';
    element.style.maxHeight = '100px'; // Достаточное значение, чтобы вмещать содержимое
}

// Функция для скрытия ошибки
function hideError(element) {
    element.style.opacity = '0';
    element.style.transform = 'translateY(20px)';
    element.style.maxHeight = '0';
}

// Обработчик события для кнопки "изменить пароль"
document.getElementById('change-password-btn').addEventListener('click', function() {
    document.querySelector('.data-left-block-info-profile').style.display = 'none';
    document.getElementById('change-password-btn').style.display = 'none';
    document.querySelector('.change-password').style.display = 'flex';
    document.getElementById('cancel-password-btn').style.display = 'block';
    document.getElementById('safe-password-btn').style.display = 'block';
});

// Обработчик события для кнопки "отменить"
document.getElementById('cancel-password-btn').addEventListener('click', function() {
    document.querySelector('.data-left-block-info-profile').style.display = 'flex';
    document.getElementById('change-password-btn').style.display = 'block';
    document.querySelector('.change-password').style.display = 'none';
    document.getElementById('cancel-password-btn').style.display = 'none';
    document.getElementById('safe-password-btn').style.display = 'none';
});

// Функция для валидации вводимых паролей
function validatePassword() {
    const password = this.value;
    const lengthErrorMessage = document.getElementById('lengthErrorMessage');
    const formatErrorMessage = document.getElementById('formatErrorMessage');

    // Скрываем все сообщения об ошибках
    hideError(lengthErrorMessage);
    hideError(formatErrorMessage);

    // Флаг для проверки валидности
    let isValid = true;

    // Проверка длины пароля
    if (password.length > 30) {
        showError(lengthErrorMessage, 'Пароль не может содержать более 30 символов');
        isValid = false;
    }

    // Проверка формата пароля
    if (!isPasswordValid(password)) {
        showError(formatErrorMessage, 'Пароль должен содержать не менее 8 символов, включать заглавные и строчные буквы латинского алфавита, хотя бы одну цифру и специальный символ @$!%*?&');
        isValid = false;
    }

    return isValid;
}

// Добавление обработчиков событий для полей ввода паролей
// document.getElementById('passwordInput').addEventListener('input', validatePassword); валидация старого пароля
document.getElementById('passwordInput1').addEventListener('input', validatePassword);
document.getElementById('passwordInput2').addEventListener('input', validatePassword);

// Обработчик события для кнопки "сохранить"
document.getElementById('safe-password-btn').addEventListener('click', function(event) {
    event.preventDefault(); // Предотвращаем отправку формы по умолчанию

    // Получаем значения паролей из полей ввода
    //const oldPassword = document.getElementById('passwordInput').value; валидация старого пароля
    const newPassword = document.getElementById('passwordInput1').value;
    const confirmPassword = document.getElementById('passwordInput2').value;

    // Получаем элементы для отображения сообщений об ошибках
    const lengthErrorMessage = document.getElementById('lengthErrorMessage');
    const formatErrorMessage = document.getElementById('formatErrorMessage');

    // Скрываем все сообщения об ошибках
    hideError(lengthErrorMessage);
    hideError(formatErrorMessage);

    // Флаг для проверки валидности
    let isValid = true;

    // Проверка длины нового пароля
    if (newPassword.length > 30) {
        showError(lengthErrorMessage, 'Пароль не может содержать более 30 символов');
        isValid = false;
    }

    // Проверка формата нового пароля
    if (!isPasswordValid(newPassword)) {
        showError(formatErrorMessage, 'Пароль должен содержать не менее 8 символов, включать заглавные и строчные буквы латинского алфавита, хотя бы одну цифру и специальный символ @$!%*?&');
        isValid = false;
    }

    // Проверка длины подтвержденного пароля
    if (confirmPassword.length > 30) {
        showError(lengthErrorMessage, 'Пароль не может содержать более 30 символов');
        isValid = false;
    }

    // Проверка формата подтвержденного пароля
    if (!isPasswordValid(confirmPassword)) {
        showError(formatErrorMessage, 'Пароль должен содержать не менее 8 символов, включать заглавные и строчные буквы латинского алфавита, хотя бы одну цифру и специальный символ @$!%*?&');
        isValid = false;
    }

    // Проверка совпадения нового пароля и подтвержденного пароля
    if (newPassword !== confirmPassword) {
        alert('Пароли не совпадают');
        isValid = false;
    }

    // Если валидация не пройдена, выводим alert и прекращаем выполнение функции
    if (!isValid) {
        alert('Ошибка: проверьте правильность заполнения полей.');
        return;
    }

    // Если все проверки пройдены
    alert('Пароль успешно изменен');
    // Здесь можно добавить действия для смены пароля (например, отправка данных на сервер)

    // Восстанавливаем видимость элементов
    document.querySelector('.data-left-block-info-profile').style.display = 'flex';
    document.getElementById('change-password-btn').style.display = 'block';
    document.querySelector('.change-password').style.display = 'none';
    document.getElementById('cancel-password-btn').style.display = 'none';
    document.getElementById('safe-password-btn').style.display = 'none';

    // Очищаем поля ввода паролей
    document.getElementById('passwordInput').value = '';
    document.getElementById('passwordInput1').value = '';
    document.getElementById('passwordInput2').value = '';
});
