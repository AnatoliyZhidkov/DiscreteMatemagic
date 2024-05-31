// // Получаем текущий путь страницы
// const currentPage = window.location.pathname;
//
// // Получаем список всех элементов меню
// const menuItems = document.querySelectorAll('.menu li');
//
// // Удаляем класс "active" у всех элементов меню
// menuItems.forEach((item) => {
//     item.classList.remove('active');
// });
//
// // Устанавливаем активный элемент меню в зависимости от текущей страницы
// if (currentPage.includes("main.html")) {
//     menuItems[0].classList.add('active');
// } else if (currentPage.includes("progress.html")) {
//     menuItems[1].classList.add('active');
// } else if (currentPage.includes("profile.html")) {
//     menuItems[2].classList.add('active');
// } else if (currentPage.includes("authorization.html")) {
//     menuItems[3].classList.add('active');
// }
//
// // Добавляем обработчик события клика на каждый элемент меню
// menuItems.forEach((menuItem) => {
//     menuItem.addEventListener('click', function() {
//         // Удаляем класс "active" у всех элементов меню
//         menuItems.forEach((item) => {
//             item.classList.remove('active');
//         });
//         // Добавляем класс "active" к элементу, на который нажали
//         this.classList.add('active');
//     });
// });


