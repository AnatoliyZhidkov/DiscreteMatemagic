const mod1 = document.getElementById('mod1');
const mod2 = document.getElementById('mod2');
const mod3 = document.getElementById('mod3');
const mod4 = document.getElementById('mod4');
const commonOptions = {
    indexAxis: 'y',
    scales: {
        x: {
            beginAtZero: true,
            min: 0,
            max: 100,
            ticks: {
                color: 'white',
                stepSize: 10
            }
        },
        y: {
            ticks: {
                color: 'white'
            }
        }
    },
    plugins: {
        legend: {
            display: false
        }
    }
};
new Chart(mod1, {
    type: 'bar',
    data: {
        labels: ['Урок 1', 'Урок 2', 'Урок 3'],
        datasets: [{
            data: [30, 60, 90],
            backgroundColor: 'rgba(0, 255, 178, 0.8)',
            borderColor: 'rgba(0, 255, 178)',
            borderWidth: 2,
            barThickness: 30 // Толщина столбцов
        }]
    },
    options: {
        ...commonOptions,
        maintainAspectRatio: false // Отключение сохранения соотношения сторон
    }
});
new Chart(mod2, {
    type: 'bar',
    data: {
        labels: ['Урок 1', 'Урок 2'],
        datasets: [{
            data: [88, 100],
            backgroundColor: 'rgba(255, 102, 102, 0.8)',
            borderColor: 'rgba(255, 102, 102)',
            borderWidth: 2,
            barThickness: 30 // Толщина столбцов
        }]
    },
    options: {
        ...commonOptions,
        maintainAspectRatio: false // Отключение сохранения соотношения сторон
    }
});
new Chart(mod3, {
    type: 'bar',
    data: {
        labels: ['Урок 1', 'Урок 2'],
        datasets: [{
            data: [33, 90],
            backgroundColor: 'rgba(252, 238, 33, 0.8)',
            borderColor: 'rgba(252, 238, 33)',
            borderWidth: 2,
            barThickness: 30 // Толщина столбцов
        }]
    },
    options: {
        ...commonOptions,
        maintainAspectRatio: false // Отключение сохранения соотношения сторон
    }
});
new Chart(mod4, {
    type: 'bar',
    data: {
        labels: ['Урок 1', 'Урок 2', 'Урок 3'],
        datasets: [{
            data: [77, 88, 100],
            backgroundColor: 'rgba(150, 87, 238, 0.8)',
            borderColor: 'rgba(150, 87, 238)',
            borderWidth: 2,
            barThickness: 30 // Толщина столбцов
        }]
    },
    options: {
        ...commonOptions,
        maintainAspectRatio: false // Отключение сохранения соотношения сторон
    }
});