export function getList() {



    return fetch('http://localhost:8081/dashboard/user/3', {
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Allow": "*",
                "Content-type": "Application/json",
            }
        })
        .then(data => data.json())



}