const URL = 'http:localhost:8080/service/1';


async function methodGet(){
    const response = await fetch(URL);
    if(!response.ok){
        console.log(response.body);
    }

    const data = await response.json();
    console.log(data);
    console.log(response)
}



async function methodPost(){
    const response = await fetch(URL, {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            name: "Balanceamento",
            shortDescription: "Realizar o processo de garantia que as rodas girem sem vibrações",
            description: "feofkefoefkoekfoefkefkeofkeofkeofkeofkeofkeofkefoekfoekfoekfeokfeokfeofkeofkefkeofkeofk",
            valueBasic: 155.56,
        })
    });
    console.log(response);
}

methodGet();

