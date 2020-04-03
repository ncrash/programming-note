// ES5 예제
var objectOne = { one: 1, two: 2, other: 0 };
var objectTwo = { three: 3, four: 4, other: -1 };

var combined = {
  one: objectOne.one,
  two: objectOne.two,
  three: objectTwo.three,
  four: objectTwo.four,
};
var combined = Object.assign({}, objectOne, objectTwo);
// combined = {one: 1, two: 2, other: -1, three: 3, four: 4}
var combined = Object.assign({}, objectTwo, objectOne);
// combined = {three: 3, four: 4, other: 0, one: 1, two: 2}
var others = Object.assign({}, combined);
delete others.other;

// ES6 예제
var combined = {
  ...objectOne,
  ...objectTwo,
};
// combined = {one: 1, two: 2, other: -1, three: 3, four: 4}
var combined = {
  ...objectTwo,
  ...objectOne,
};
// combined = {three: 3, four: 4, other: 0, one: 1, two: 2}
var { other, ...others } = combined;
// other = 0
// others = {three: 3, four: 4, one: 1, two: 2}
