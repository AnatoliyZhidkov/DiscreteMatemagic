// document.querySelectorAll('.theoryButton').forEach(button => {
//     button.addEventListener('click', function() {
//         const lessonId = this.getAttribute('data-lesson');
//         window.location.href = `theories/theory${lessonId}.html`;
//     });
// });

// document.querySelectorAll('.testButton').forEach(button => {
//     button.addEventListener('click', function() {
//         const lessonId = this.getAttribute('data-lesson');
//         window.location.href = `tests/test${lessonId}.html`;
//     });
// });


document.addEventListener("DOMContentLoaded", function() {
    const lessons = document.querySelectorAll(".item-lesson");

    lessons.forEach(lesson => {
        const overlay = lesson.querySelector(".overlay");
        const image = lesson.querySelector(".images-item-lesson");

        if (!overlay || !image) {
            console.error("Не найден один из элементов: .overlay или .images-item-lesson");
            return;
        }

        // Изначально делаем overlay невидимым и некликабельным
        overlay.style.visibility = "hidden";
        overlay.style.opacity = "0";

        // Обработчик клика по изображению урока
        image.addEventListener("click", function(event) {
            // Закрываем все остальные overlays
            document.querySelectorAll(".overlay").forEach(el => {
                el.style.visibility = "hidden";
                el.style.opacity = "0";
            });

            // Открываем только этот overlay
            overlay.style.visibility = "visible";
            overlay.style.opacity = "1";

            event.stopPropagation(); // Предотвращаем всплытие события
        });

        // Обработчик клика по overlay, чтобы предотвратить закрытие при клике на самом overlay
        overlay.addEventListener("click", function(event) {
            event.stopPropagation();
        });
    });

    // Обработчик клика по документу, который скрывает все overlays
    document.addEventListener("click", function() {
        document.querySelectorAll(".overlay").forEach(ov => {
            ov.style.visibility = "hidden";
            ov.style.opacity = "0";
        });
    });
});




