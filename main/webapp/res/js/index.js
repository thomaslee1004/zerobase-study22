let getLocation = function () {
    return new Promise(function (resolve, reject) {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(showPosition);

            // showPosition이 비동기로 실행되므로 resolve를 showPosition 내부에서 호출하도록 변경
        }

        function showPosition(position) {
            document.getElementById('inputLat').value = position.coords.latitude;
            document.getElementById('inputLnt').value = position.coords.longitude;

            resolve(); // 위치 정보를 설정한 후에 resolve 호출
        }
    });
}

function getWifi() {
    let inputLat = document.getElementById('inputLat').value;
    let inputLnt = document.getElementById('inputLnt').value;

    if (!inputLat || !inputLnt) {
        getLocation()
            .then(requestWifi); // 위치 정보를 얻은 후에 requestWifi 호출
    } else {
        requestWifi(); // 이미 위치 정보가 입력되어 있으면 바로 requestWifi 호출
    }
}

let requestWifi = function () {
    return new Promise(function (resolve, reject) {
        let lat = document.getElementById('inputLat').value;
        let lnt = document.getElementById('inputLnt').value;

        // TODO: 1. Ajax요청

        // TODO: 2. list로 붙이기


        resolve();
    });
}


window.addEventListener('load', function (event) {

    document.getElementById('getPositionButton').addEventListener('click', function (event) {
        getLocation();
    });

    document.getElementById('getWifiButton').addEventListener('click', function (event) {
        getWifi();
    });

});