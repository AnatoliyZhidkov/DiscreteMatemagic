// Получаем кнопки и элементы, которые нужно показать/скрыть
const changePasswordBtn = document.getElementById("change-password-btn");
const cancelPasswordBtn = document.getElementById("cancel-password-btn");
const safePasswordBtn = document.getElementById("safe-password-btn");
const changePasswordForm = document.querySelector(".change-password");
const dataLeftBlock = document.querySelector(".data-left-block-info-profile");

// Обработчик события для кнопки "Изменить пароль"
changePasswordBtn.addEventListener("click", function() {
    // Скрываем элементы, которые нужно скрыть
    dataLeftBlock.style.display = "none";
    changePasswordForm.style.display = "flex";
    cancelPasswordBtn.style.display = "inline-block";
    safePasswordBtn.style.display = "inline-block";
    changePasswordBtn.style.display = "none";
});

// Обработчик события для кнопки "Отменить"
cancelPasswordBtn.addEventListener("click", function() {
    // Показываем элементы, которые нужно показать
    dataLeftBlock.style.display = "flex";
    changePasswordBtn.style.display = "inline-block";
    changePasswordForm.style.display = "none";
    cancelPasswordBtn.style.display = "none";
    safePasswordBtn.style.display = "none";
});

// Обработчик события для кнопки "Сохранить"
safePasswordBtn.addEventListener("click", function() {
    // Показываем элементы, которые нужно показать
    dataLeftBlock.style.display = "flex";
    changePasswordBtn.style.display = "inline-block";
    changePasswordForm.style.display = "none";
    cancelPasswordBtn.style.display = "none";
    safePasswordBtn.style.display = "none";
});

const passwordInput = document.getElementById('passwordInput');
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

const passwordInput1 = document.getElementById('passwordInput1');
const passwordInput2 = document.getElementById('passwordInput2');
const lengthErrorMessage1 = document.getElementById('lengthErrorMessage1');
const formatErrorMessage1 = document.getElementById('formatErrorMessage1');
const lengthErrorMessage2 = document.getElementById('lengthErrorMessage2');
const formatErrorMessage2 = document.getElementById('formatErrorMessage2');

passwordInput1.addEventListener('input', function() {
    const passwordValue = this.value.trim();
    const minLength = 8;
    const maxLength = 30; // Максимальная длина пароля
    const lengthPattern = new RegExp(`^.{${minLength},${maxLength}}$`);
    const formatPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#%^&*-+])[A-Za-z\d!@#%^&*-+]*$/;

    // Проверка минимальной длины пароля
    if (!lengthPattern.test(passwordValue)) {
        lengthErrorMessage1.style.display = 'block';
    } else {
        lengthErrorMessage1.style.display = 'none';
    }

    // Проверка разрешенных символов пароля
    if (!formatPattern.test(passwordValue)) {
        formatErrorMessage1.style.display = 'block';
    } else {
        formatErrorMessage1.style.display = 'none';
    }
});
passwordInput2.addEventListener('input', function() {
    const passwordValue = this.value.trim();
    const minLength = 8;
    const maxLength = 30; // Максимальная длина пароля
    const lengthPattern = new RegExp(`^.{${minLength},${maxLength}}$`);
    const formatPattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#%^&*-+])[A-Za-z\d!@#%^&*-+]*$/;

    // Проверка минимальной длины пароля
    if (!lengthPattern.test(passwordValue)) {
        lengthErrorMessage2.style.display = 'block';
    } else {
        lengthErrorMessage2.style.display = 'none';
    }

    // Проверка разрешенных символов пароля
    if (!formatPattern.test(passwordValue)) {
        formatErrorMessage2.style.display = 'block';
    } else {
        formatErrorMessage2.style.display = 'none';
    }
});
