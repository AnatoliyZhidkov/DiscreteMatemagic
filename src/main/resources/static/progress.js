document.addEventListener('DOMContentLoaded', function() {
    function createChart(elementId, results, backgroundColor, borderColor) {
        const ctx = document.getElementById(elementId);
        const labels = results.map((_, index) => `Тест ${index + 1}`);

        new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    data: results,
                    backgroundColor: backgroundColor,
                    borderColor: borderColor,
                    borderWidth: 2,
                    barThickness: 30 // Толщина столбцов
                }]
            },
            options: {
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
                },
                maintainAspectRatio: false // Отключение сохранения соотношения сторон
            }
        });
    }

    const module1Results = JSON.parse(document.getElementById('mod1').dataset.resultsJson);
    const module2Results = JSON.parse(document.getElementById('mod2').dataset.resultsJson);
    const module3Results = JSON.parse(document.getElementById('mod3').dataset.resultsJson);
    const module4Results = JSON.parse(document.getElementById('mod4').dataset.resultsJson);

    createChart('mod1', module1Results, 'rgba(0, 255, 178, 0.8)', 'rgba(0, 255, 178)');
    createChart('mod2', module2Results, 'rgba(255, 102, 102, 0.8)', 'rgba(255, 102, 102)');
    createChart('mod3', module3Results, 'rgba(252, 238, 33, 0.8)', 'rgba(252, 238, 33)');
    createChart('mod4', module4Results, 'rgba(150, 87, 238, 0.8)', 'rgba(150, 87, 238)');
});