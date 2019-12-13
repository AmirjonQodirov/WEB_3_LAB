function updateTime() {
    const date = new Date();
    const options = {
        year: '2-digit',
        month: '2-digit',
        day: '2-digit',
        timezone: 'UTC',
        hour: '2-digit',
        minute: '2-digit',
        second: '2-digit'
    };
    document.querySelector("#time").innerHTML = date.toLocaleString("ru", options);
}
document.addEventListener('DOMContentLoaded', ()=> {
    window.setInterval(updateTime, 1000);
});

