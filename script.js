// URLs de la API para cada entidad
const API_URLS = {
    productos: 'http://localhost:8080/api/productos',
    clientes: 'http://localhost:8080/api/clientes',
    // ... agrega el resto de las URLs aquí
};

document.addEventListener('DOMContentLoaded', () => {
    // --- Lógica de Pestañas ---
    const tabButtons = document.querySelectorAll('.tab-button');
    const tabContents = document.querySelectorAll('.tab-content');

    tabButtons.forEach(button => {
        button.addEventListener('click', () => {
            tabButtons.forEach(btn => btn.classList.remove('active'));
            button.classList.add('active');

            const tabId = button.dataset.tab;
            tabContents.forEach(content => {
                if (content.id === tabId) {
                    content.classList.add('active');
                } else {
                    content.classList.remove('active');
                }
            });

            // Llamar a la función de carga de datos para la pestaña activa
            loadDataForTab(tabId);
        });
    });

    // Cargar datos al inicio (pestaña de productos por defecto)
    loadDataForTab('productos');

    // --- Lógica de Formularios y Eventos ---
    
    // Evento para el formulario de Productos
    const productoForm = document.getElementById('producto-form');
    if (productoForm) {
        productoForm.addEventListener('submit', async (e) => {
            e.preventDefault();
            await saveProduct();
            // Recargar la lista después de guardar
            await fetchAndDisplayProducts();
        });
    }

    // Evento para el formulario de Clientes
    const clienteForm = document.getElementById('cliente-form');
    if (clienteForm) {
        clienteForm.addEventListener('submit', async (e) => {
            e.preventDefault();
            await saveCliente();
            // Recargar la lista después de guardar
            await fetchAndDisplayClientes();
        });
    }

    // ... Agrega los eventos para los demás formularios aquí
});

// --- Funciones de Carga de Datos por Pestaña ---
async function loadDataForTab(tabId) {
    switch(tabId) {
        case 'productos':
            await fetchAndDisplayProducts();
            break;
        case 'clientes':
            await fetchAndDisplayClientes();
            break;
        // ... Agrega los demás casos aquí
    }
}

// --- Funciones CRUD para la Entidad 'Productos' ---

async function fetchAndDisplayProducts() {
    try {
        const response = await fetch(API_URLS.productos);
        if (!response.ok) throw new Error('Error al obtener los productos.');
        const products = await response.json();
        const listBody = document.getElementById('producto-list-body');
        listBody.innerHTML = '';
        products.forEach(product => {
            const row = `<tr>
                <td>${product.id_producto}</td>
                <td>${product.nombre_producto}</td>
                <td>${product.descripcion}</td>
                <td>${product.precio}</td>
                <td>${product.stock}</td>
                <td>
                    <button class="edit-btn" onclick="editProduct(${product.id_producto})">Editar</button>
                    <button class="delete-btn" onclick="deleteProduct(${product.id_producto})">Eliminar</button>
                </td>
            </tr>`;
            listBody.innerHTML += row;
        });
    } catch (error) {
        console.error('Error:', error);
    }
}

async function saveProduct() {
    const product = {
        nombre_producto: document.getElementById('nombre_producto').value,
        descripcion: document.getElementById('descripcion').value,
        precio: parseFloat(document.getElementById('precio').value),
        stock: parseInt(document.getElementById('stock').value)
    };
    try {
        const response = await fetch(API_URLS.productos, {
            method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(product),
        });
        if (response.ok) alert('Producto guardado con éxito.');
        else alert('Error al guardar el producto.');
    } catch (error) {
        console.error('Error:', error);
    }
}

async function deleteProduct(id) {
    if (confirm('¿Estás seguro de que quieres eliminar este producto?')) {
        try {
            const response = await fetch(`${API_URLS.productos}/${id}`, { method: 'DELETE' });
            if (response.ok) {
                alert('Producto eliminado con éxito.');
                await fetchAndDisplayProducts();
            } else alert('Error al eliminar el producto.');
        } catch (error) {
            console.error('Error:', error);
        }
    }
}

async function editProduct(id) { console.log(`Función de edición pendiente para el producto con ID: ${id}`); }


// --- Funciones CRUD para la Entidad 'Clientes' ---

async function fetchAndDisplayClientes() {
    try {
        const response = await fetch(API_URLS.clientes);
        if (!response.ok) throw new Error('Error al obtener los clientes.');
        const clientes = await response.json();
        const listBody = document.getElementById('cliente-list-body');
        listBody.innerHTML = '';
        clientes.forEach(cliente => {
            const row = `<tr>
                <td>${cliente.id_cliente}</td>
                <td>${cliente.nombre}</td>
                <td>${cliente.direccion}</td>
                <td>${cliente.email}</td>
                <td>${cliente.telefono}</td>
                <td>
                    <button class="edit-btn" onclick="editCliente(${cliente.id_cliente})">Editar</button>
                    <button class="delete-btn" onclick="deleteCliente(${cliente.id_cliente})">Eliminar</button>
                </td>
            </tr>`;
            listBody.innerHTML += row;
        });
    } catch (error) {
        console.error('Error:', error);
    }
}

async function saveCliente() {
    const cliente = {
        nombre: document.getElementById('cliente-nombre').value,
        direccion: document.getElementById('cliente-direccion').value,
        email: document.getElementById('cliente-email').value,
        telefono: document.getElementById('cliente-telefono').value
    };
    try {
        const response = await fetch(API_URLS.clientes, {
            method: 'POST', headers: {'Content-Type': 'application/json'}, body: JSON.stringify(cliente),
        });
        if (response.ok) alert('Cliente guardado con éxito.');
        else alert('Error al guardar el cliente.');
    } catch (error) {
        console.error('Error:', error);
    }
}

async function deleteCliente(id) {
    if (confirm('¿Estás seguro de que quieres eliminar este cliente?')) {
        try {
            const response = await fetch(`${API_URLS.clientes}/${id}`, { method: 'DELETE' });
            if (response.ok) {
                alert('Cliente eliminado con éxito.');
                await fetchAndDisplayClientes();
            } else alert('Error al eliminar el cliente.');
        } catch (error) {
            console.error('Error:', error);
        }
    }
}

async function editCliente(id) { console.log(`Función de edición pendiente para el cliente con ID: ${id}`); }