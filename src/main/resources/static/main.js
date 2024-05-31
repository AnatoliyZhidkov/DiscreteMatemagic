document.querySelectorAll('.theoryButton').forEach(button => {
    button.addEventListener('click', function() {
        const lessonId = this.getAttribute('data-lesson');
        window.location.href = `theories/theory${lessonId}.html`;
    });
});

document.querySelectorAll('.testButton').forEach(button => {
    button.addEventListener('click', function() {
        const lessonId = this.getAttribute('data-lesson');
        window.location.href = `tests/test${lessonId}.html`;
    });
});