function f() {
    var x  = "var a =3;var b =5;alert(a+b);";
    eval(x);
}
// 在运行时候，代码可以根据某些条件改变自身结构
f();