window.addEventListener('load', function () {

    //Buscamos y obtenemos el formulario donde estan
    //los datos que el usuario pudo haber modificado del estudiante
    const formulario = document.querySelector('#update_student_form');
    formulario.addEventListener('submit', function (event) {
        let studentId = document.querySelector('#dentist_id').value;

        //creamos un JSON que tendrá los datos del estudiante
        //a diferencia de un estudiante nuevo en este caso enviamos el id
        //para poder identificarlo y modificarlo para no cargarlo como nuevo
        const formData = {
            id: document.querySelector('#dentist_id').value,
            registrationNumber: document.querySelector('#matricula').value,
            firstName: document.querySelector('#nombre').value,
            lastName: document.querySelector('#apellido').value,

        };

        //invocamos utilizando la función fetch la API estudiantes con el método PUT
        //que modificará al estudiante que enviaremos en formato JSON
        const url = '/dentist';
        const settings = {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }
          fetch(url,settings)
          .then(response => response.json())

    })
 })

    //Es la funcion que se invoca cuando se hace click sobre el id de un estudiante del listado
    //se encarga de llenar el formulario con los datos del estudiante
    //que se desea modificar
    function findBy(id) {
          const url = '/dentist'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let dentist = data;
              document.querySelector('#dentist_id').value = dentist.id;
              document.querySelector('#matricula').value = dentist.registrationNumber;
              document.querySelector('#nombre').value = dentist.firstName;
              document.querySelector('#apellido').value = dentist.lastName;

            //el formulario por default esta oculto y al editar se habilita
              document.querySelector('#div_student_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
              console.log("Error: " + error)
          })
      }