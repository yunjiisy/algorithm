function solution(s) {
    var same = 0
    var diff = 0
    var count = 0
    let compare = s[0]
    let i = 0
    while(i<s.length) {
        if(compare === s[i]){
            console.log(s[i],compare)
            same++
            console.log("same"+same)

        }
        if(compare !== s[i]) {
            console.log(s[i],compare)

            diff++
            console.log("diff"+diff)
        }
        if(same === diff || i === s.length-1) {

            same = 0
            diff = 0
            count++
            compare = s[i+1]
            console.log('count'+count)
        }
        i++
        
    }
    return count
}
