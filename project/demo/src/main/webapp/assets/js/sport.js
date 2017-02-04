/**
 * Created by kylin on 16/10/2016.
 */

sport = {
    initSportsCharts: function () {
        // 睡眠时间柱状图
        var dataSleepBar = {
            labels: ['周1', '周2', '周3', '周4', '周5', '周6', '周7'],
            series: [
                [6, 7, 6, 5, 6, 8, 9]
            ]
        };

        var optionsSleepBar = {
            axisX: {
                showGrid: false
            },
            low: 0,
            high: 12,

            chartPadding: { top: 0, right: 5, bottom: 0, left: 0}
        };

        var responsiveOptions = [
            ['screen and (max-width: 640px)', {
                seriesBarDistance: 5,
                axisX: {
                    labelInterpolationFnc: function (value) {
                        return value[0];
                    }
                }
            }]
        ];

        var sleepBarChart = Chartist.Bar('#sleepBarChart', dataSleepBar, optionsSleepBar, responsiveOptions);
        md.startAnimationForBarChart(sleepBarChart);


        /* ----------==========     步数柱状图    ==========---------- */

        var datastepsLineChart = {
            labels: ['10-01', '10-02', '10-03', '10-04', '10-05', 
                '10-06', '10-07', '10-08', '10-09', '10-10', '10-11', '10-12'],
            series: [
                [5420, 4430, 3200, 7800, 5503, 4053, 3206, 4034, 5068, 6100, 7506, 8905]
            ]
        };
        var optionsstepsLineChart = {
            axisX: {
                showGrid: false
            },
            low: 0,
            high: 10000,
            chartPadding: { top: 0, right: 5, bottom: 0, left: 0}
        };
        
        var stepsLineChart = Chartist.Bar('#stepsLineChart', datastepsLineChart, optionsstepsLineChart, responsiveOptions);
        md.startAnimationForBarChart(stepsLineChart);

        // 心率折线图
        var dataHeartChart = {
            labels: ['10-01', '10-02', '10-03', '10-04', '10-05',
                '10-06', '10-07', '10-08', '10-09', '10-10', '10-11', '10-12'],
            series: [
                [70, 80, 80, 90, 95, 70, 80, 60, 70, 80, 90, 80]
            ]
        };

        var optionsHeartChart = {
            low: 0,
            showArea: true
        };

        var heartRateChart = new Chartist.Line('#heartRateChart',dataHeartChart, optionsHeartChart);
        md.startAnimationForLineChart(heartRateChart);
        
        // 跑步历史柱状图
        var dataRunLineChart = {
            labels: ['10-01', '10-02', '10-03', '10-04', '10-05',
                '10-06', '10-07', '10-08', '10-09', '10-10', '10-11', '10-12'],
            series: [
                [0, 3, 3, 5, 0, 7, 4, 0, 8.5, 0, 6, 3]
            ]
        };
        var optionsRunLineChart = {
            axisX: {
                showGrid: false
            },
            low: 0,
            high: 10,
            chartPadding: { top: 0, right: 5, bottom: 0, left: 0}
        };

        var runLineChart = Chartist.Bar('#runLineChart', dataRunLineChart, optionsRunLineChart, responsiveOptions);
        md.startAnimationForBarChart(runLineChart);



        var dataWeightChart = {
            labels: ['3月', '4月', '5月', '6月', '7月',
                '8月', '9月', '10月', '11月', '12月'],
            series: [
                [150, 151, 152, 151, 153, 
                    154, 155, 156, 160, 158, 156, 156]
            ]
        };
        var optionsWeightChart = {
            axisX: {
                showGrid: false
            },
            low: 145,
            high: 175,
            chartPadding: { top: 0, right: 5, bottom: 0, left: 0}
        };

        var stepsWeightChart = Chartist.Line('#weightChart', dataWeightChart, optionsWeightChart, responsiveOptions);
        md.startAnimationForBarChart(stepsWeightChart);


        var dataFatChart = {
            labels: ['3月', '4月', '5月', '6月', '7月',
                '8月', '9月', '10月', '11月', '12月'],
            series: [
                [18, 18, 18, 19, 19,
                    19, 19, 20, 22, 20, 19, 18]
            ]
        };
        var optionsFatChart = {
            axisX: {
                showGrid: false
            },
            axisY: {
                labelInterpolationFnc: function(value) {
                    return value + '%';
                }
            },
            low: 15,
            high: 25,
            chartPadding: { top: 0, right: 5, bottom: 0, left: 0}
        };

        var stepsFatChart = Chartist.Line('#fatChart', dataFatChart, optionsFatChart, responsiveOptions);
        md.startAnimationForBarChart(stepsFatChart);
        
    }
};