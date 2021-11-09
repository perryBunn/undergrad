let diff
let type
let question
let answer
let score = 0

function genQuestion() {
    return Math.floor(2*Math.random())

}

function equation(difficulty = 1) {
    let a, b, c, s
    s = Math.floor(21*difficulty*Math.random() - difficulty + 1) - (10*difficulty)
    a = Math.floor(11*difficulty*Math.random() - difficulty + 1) - (5*difficulty)
    if (a === 0) {
        a++
    }
    c = Math.floor(51*difficulty*Math.random() - difficulty + 1) - (25*difficulty)
    b = -(s*a-c)
    return [a, b, c, s]
}

function multiplication(difficulty = 1) {
    let a,b,s
    a = Math.floor(26*difficulty*Math.random() - difficulty + 1)
    b = Math.floor(26*difficulty*Math.random() - difficulty + 1)
    s = a*b
    return [a, b, s]
}

function print(question, type) {
    let div = document.getElementById('question');
    let equation
    if (type === 1) {
        equation = "" + question[0] + "x + " + question[1] + " = " + question[2]
    } else {
        equation = "" + question[0] + "*" + question[1] + " = ?"
    }
    div.innerHTML = equation;
    let s = document.getElementById('score')
    s.innerHTML = score
}

function isYes(a, S) {
    let res =  a == S
    if (res) {
        score += diff * 100
        alert("Correct!")
    }
}

function newQuestion() {
    type = genQuestion()
    if (type === 1) {
        question = equation(diff)
        answer = question[3]
    } else {
        question = multiplication(diff)
        answer = question[2]
    }
    print(question, type)
}

function clearForm() {
    let form = document.getElementById("form")
    form.reset()
}

function difficulty() {
    let res = prompt("Enter a difficulty from 1-4: ")
    if (res <= 0) {
        res = 1
    }
    return res
}

document.getElementById("submit").addEventListener('click', e => {
    let answerSubmit = document.querySelector("#submit");
    let userRes = document.getElementById("answer").value
    answerSubmit.onclick = isYes(userRes, answer);
    clearForm()
    newQuestion()
})

window.onload = function () {
    diff = difficulty()
    newQuestion()
}

let input = document.getElementById('answer');
input.addEventListener('keypress', function(event) {
    if (event.keyCode == 13) {
        event.preventDefault()
        document.getElementById('submit').click()
    }
})
