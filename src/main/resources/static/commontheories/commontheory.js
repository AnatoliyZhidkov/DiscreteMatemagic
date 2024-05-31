document.querySelectorAll('a.scroll-to').forEach(anchor => {
    anchor.addEventListener('click', function (e) {
        e.preventDefault();
        const targetId = this.getAttribute('href').substring(1);
        const targetElement = document.getElementById(targetId);
        const offsetPosition = targetElement.getBoundingClientRect().top + window.scrollY - document.querySelector('header').offsetHeight;

        window.scrollTo({
            top: offsetPosition,
            behavior: 'smooth'
        });
    });
});

function goBack() {
    window.history.back();
}
