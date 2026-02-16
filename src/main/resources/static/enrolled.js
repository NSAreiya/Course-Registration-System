function showenrolledCourses(){
    fetch("http://localhost:8080/admin/courses/enrolled", {
        method: "GET",
        credentials: "include"   // ⭐ MUST ADD
    })
    .then((response) => {
        if(!response.ok){
            throw new Error("Access denied or not logged in");
        }
        return response.json();
    })
    .then((enrolled)=>{

        const studentCount = document.getElementById("studentCount");
        studentCount.textContent = `Total Enrolled Students: ${enrolled.length}`;

        const dataTable=document.getElementById("enrolledTable");

        enrolled.forEach(enrol => {
            var row =`<tr>
            <td>${enrol.name}</td>
            <td>${enrol.emailId}</td>
            <td>${enrol.courseName}</td>
            </tr>`
            dataTable.innerHTML += row;
        });
    })
    .catch(error => {
        console.error(error);
        alert("You are not authorized! Please login as ADMIN.");
    });
}
