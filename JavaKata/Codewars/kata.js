//take in array of strings/integers and only return integers
function filter_list(l) {
  let resArr = []
  let j = 0;
  for(let i = 0; i < l.length; i++) { [0, "c", 1]
    if(l[i].isNumber()) {
        resArr[j] = l[i]; [0, 1]
        j++
    }
  }
  return resArr
}