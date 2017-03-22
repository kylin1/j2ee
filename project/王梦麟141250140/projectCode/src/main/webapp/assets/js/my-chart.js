var DrawChart = (function () {

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

  return {
    createLineChart: function (id, data, high, low, yValue) {

      var options = {
        high: high,
        low: low,
        axisX: {
          showGrid: false
        },

        axisY: {
          labelInterpolationFnc: function (value) {
            return value + yValue;
          }
        },

        chartPadding: {top: 0, right: 15, bottom: 0, left: 20}
      };

      var runLineChart = Chartist.Line(document.getElementById(id), data, options, responsiveOptions);
      md.startAnimationForLineChart(runLineChart);
    },

    createBarChart: function (id, data, high, low, yValue) {

      var options = {
        high: high,
        low: low,
        axisX: {
          showGrid: false
        },

        axisY: {
          labelInterpolationFnc: function (value) {
            return value + yValue;
          }
        },

        chartPadding: {top: 0, right: 15, bottom: 0, left: 20}
      };

      var sleepBarChart = Chartist.Bar(document.getElementById(id), data, options, responsiveOptions);
      md.startAnimationForBarChart(sleepBarChart);
    }
  }
})();