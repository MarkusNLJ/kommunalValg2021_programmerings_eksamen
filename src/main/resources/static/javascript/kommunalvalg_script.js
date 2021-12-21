const URL = "http://localhost:8080/Kandidater";
let candidates = []

function fetchCandidates() {
    fetch(URL)
        .then(res => res.json())
        .then(data => {
            candidates = data
            console.log(data)
            makeAttractionRows(candidates)
        })
}

fetchCandidates()

function makeAttractionRows(can) {
    const rows = can.map(can => `
         <tr>
           <td>${can.id}</td>
           <td>${can.name}</td>
           <td>${can.politicanView}</td>
         </tr>
        `)
    let headerRows = ` <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>politisk holdning</th>
                    </tr>`
    document.getElementById("parti-body").innerHTML = rows.join("")
    document.getElementById("parti-header").innerHTML = headerRows
}