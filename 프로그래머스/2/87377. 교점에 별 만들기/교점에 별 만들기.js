function solution(line) {
    var points = [];
    line.forEach((l1, i) => {
        var A = l1[0], B = l1[1], E = l1[2];
        line.slice(i+1).forEach((l2) => {
            var C = l2[0], D = l2[1], F=l2[2];
            var div = A*D-B*C;
            if(div == 0 || (B*F-E*D) % div || (C*E-A*F) % div) return;
            var x = (B*F-E*D)/div, y = (C*E-A*F)/div;
            points.push([x, y]);            
        });
    });
    console.log(points);

    var xmin = points[0][0], xmax = points[0][0];
    var ymin = points[0][1], ymax = points[0][1];
    points.forEach((point) => {
        xmin = Math.min(xmin, point[0]);
        xmax = Math.max(xmax, point[0]);
        ymin = Math.min(ymin, point[1]);
        ymax = Math.max(ymax, point[1]);
    });

    var answer = Array.from({length: ymax-ymin+1}, 
                           ()=>Array.from({length: xmax-xmin+1}, ()=>"."));
    points.forEach((point) => {answer[point[1]-ymin][point[0]-xmin] = '*'});
    answer = answer.map((line) => line.join('')).reverse();
    return answer;
}