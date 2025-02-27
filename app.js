const canvas = document.getElementById('canvas');
const ctx = canvas.getContext('2d');
const resetButton = document.getElementById('reset');
const messageDiv = document.getElementById('message');

let isDrawing = false;
let startX, startY;
const circles = [];

function getRandomColor() {
    const letters = '0123456789ABCDEF';
    let color = '#';
    for (let i = 0; i < 6; i++) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

canvas.addEventListener('mousedown', (e) => {
    isDrawing = true;
    startX = e.offsetX;
    startY = e.offsetY;
});

canvas.addEventListener('mousemove', (e) => {
    if (isDrawing) {
        const currentX = e.offsetX;
        const currentY = e.offsetY;
        const radius = Math.sqrt(Math.pow(currentX - startX, 2) + Math.pow(currentY - startY, 2));
        ctx.clearRect(0, 0, canvas.width, canvas.height);
        drawCircles();
        ctx.beginPath();
        ctx.arc(startX, startY, radius, 0, Math.PI * 2);
        ctx.fillStyle = getRandomColor();
        ctx.fill();
        ctx.closePath();
    }
});

canvas.addEventListener('mouseup', (e) => {
    if (isDrawing) {
        isDrawing = false;
        const endX = e.offsetX;
        const endY = e.offsetY;
        const radius = Math.sqrt(Math.pow(endX - startX, 2) + Math.pow(endY - startY, 2));
        circles.push({ x: startX, y: startY, radius: radius, color: getRandomColor() });
        drawCircles();
    }
});

canvas.addEventListener('click', (e) => {
    const clickX = e.offsetX;
    const clickY = e.offsetY;
    let hit = false;
    circles.forEach(circle => {
        const distance = Math.sqrt(Math.pow(clickX - circle.x, 2) + Math.pow(clickY - circle.y, 2));
        if (distance <= circle.radius) {
            hit = true;
        }
    });
    messageDiv.textContent = hit ? 'Hit' : 'Miss';
});

canvas.addEventListener('dblclick', (e) => {
    const clickX = e.offsetX;
    const clickY = e.offsetY;
    for (let i = 0; i < circles.length; i++) {
        const circle = circles[i];
        const distance = Math.sqrt(Math.pow(clickX - circle.x, 2) + Math.pow(clickY - circle.y, 2));
        if (distance <= circle.radius) {
            circles.splice(i, 1);
            break;
        }
    }
    drawCircles();
});

resetButton.addEventListener('click', () => {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    circles.length = 0;
    messageDiv.textContent = '';
});

function drawCircles() {
    circles.forEach(circle => {
        ctx.beginPath();
        ctx.arc(circle.x, circle.y, circle.radius, 0, Math.PI * 2);
        ctx.fillStyle = circle.color;
        ctx.fill();
        ctx.closePath();
    });
}