let randomColor = "#"+((1<<24)*Math.random()|0).toString(16);
let element = document.getElementById("randomColor");
element.style.setProperty("background-color", randomColor, "important")


