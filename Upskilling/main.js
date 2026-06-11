let formSubmitted = false;

function confirmSubmit() {
  formSubmitted = true;
  document.getElementById("confirmation").textContent =
    "Registration submitted successfully!";
}

window.onbeforeunload = function () {
  if (!formSubmitted) {
    return "You have unsaved changes!";
  }
};

function validatePhone() {
  let phone = document.getElementById("phone").value;
  if (phone.length !== 10) {
    alert("Phone must be 10 digits");
  }
}

function showFee() {
  let type = document.getElementById("eventType").value;
  let fee = 0;

  if (type === "Workshop") fee = 100;
  if (type === "Music") fee = 75;
  if (type === "Sports") fee = 50;

  document.getElementById("fee").textContent = "Fee: $" + fee;
}

function enlarge(img) {
  img.style.width = "300px";
}

function countChars() {
  let count = document.getElementById("feedback").value.length;
  document.getElementById("counter").textContent = count + " characters";
}

function videoReady() {
  document.getElementById("videoStatus").textContent = "Video ready to play";
}

function savePreference() {
  let value = document.getElementById("eventType").value;

  localStorage.setItem("preferredEvent", value);
  sessionStorage.setItem("preferredEvent", value);
}

window.onload = function () {
  let saved = localStorage.getItem("preferredEvent");

  if (saved) {
    document.getElementById("eventType").value = saved;
  }
};

function clearPreferences() {
  localStorage.clear();
  sessionStorage.clear();

  document.getElementById("eventType").selectedIndex = 0;
}

function findNearbyEvents() {
  if (!navigator.geolocation) {
    document.getElementById("location").textContent =
      "Geolocation is not supported by your browser";
    return;
  }

  navigator.geolocation.getCurrentPosition(showPosition, showError, {
    enableHighAccuracy: true,
    timeout: 5000,
  });
}

function showPosition(position) {
  document.getElementById("location").innerHTML =
    "Latitude: " +
    position.coords.latitude +
    "<br>Longitude: " +
    position.coords.longitude;
}

function showError(error) {
  switch (error.code) {
    case error.PERMISSION_DENIED:
      document.getElementById("location").textContent = "Permission denied";
      break;

    case error.TIMEOUT:
      document.getElementById("location").textContent = "Request timed out";
      break;

    default:
      document.getElementById("location").textContent =
        "Unable to retrieve location";
  }
}

console.log("Welcome to the Community Portal");
