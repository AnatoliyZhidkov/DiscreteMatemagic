// Обработчик для beforeunload, который спрашивает пользователя, действительно ли он хочет покинуть страницу
function handleBeforeUnload(e) {
    var confirmationMessage = 'Вы уверены, что хотите покинуть страницу? Ваши ответы будут потеряны.';
    e.returnValue = confirmationMessage;
    return confirmationMessage;
}

// Включение предупреждения о выходе
function enableUnloadWarning() {
    window.addEventListener('beforeunload', handleBeforeUnload);
}

// Отключение предупреждения о выходе
function disableUnloadWarning() {
    window.removeEventListener('beforeunload', handleBeforeUnload);
}

// Начальная активация предупреждений
enableUnloadWarning();

// Поддержка истории для обработки событий назад
history.pushState(null, null, window.location.href);

// Обработчик для popstate
window.addEventListener('popstate', function (e) {
    var confirmationMessage = 'Вы уверены, что хотите покинуть страницу? Ваши ответы будут потеряны.';
    // Изменённая логика: если пользователь подтверждает выход, позволяем браузеру перейти назад
    if (confirm(confirmationMessage)) {
        // Переход назад
        history.go(-1);
    } else {
        // Если пользователь отменяет выход, возвращаем текущее состояние в историю
        history.pushState(null, null, window.location.href);
    }
});

document.addEventListener('DOMContentLoaded', function() {
    var inputs = document.querySelectorAll('.reply');
    inputs.forEach(function(input) {
        input.addEventListener('keydown', function(event) {
            if (event.key === 'Enter') {
                event.preventDefault(); // Отменяет стандартное поведение
                return false; // Предотвращает дальнейшее распространение события
            }
        });
    });
});
