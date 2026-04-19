// clientes.js — lógica de la vista de clientes
async function cargarClientes() {
  const clientes = await api.get('clientes');
  const thead = document.getElementById('thead-row');
  const tbody = document.getElementById('tabla-body');

  thead.innerHTML = `
    <th class="px-4 py-3">ID</th>
    <th class="px-4 py-3">Nombre</th>
    <th class="px-4 py-3">Apellido</th>
    <th class="px-4 py-3">Teléfono</th>
    <th class="px-4 py-3">Email</th>
    <th class="px-4 py-3">Acciones</th>`;

  tbody.innerHTML = clientes.map(c => `
    <tr class="hover:bg-gray-50">
      <td class="px-4 py-3">${c.idCliente}</td>
      <td class="px-4 py-3">${c.nombre}</td>
      <td class="px-4 py-3">${c.apellido}</td>
      <td class="px-4 py-3">${c.telefono ?? '—'}</td>
      <td class="px-4 py-3">${c.email ?? '—'}</td>
      <td class="px-4 py-3">
        <button onclick="eliminarCliente(${c.idCliente})"
          class="text-red-500 hover:underline text-xs">Eliminar</button>
      </td>
    </tr>`).join('');
}

async function eliminarCliente(id) {
  if (!confirm('¿Eliminar este cliente?')) return;
  await api.delete('clientes', id);
  cargarClientes();
}

function abrirModal() {
  alert('Aquí iría el formulario de nuevo cliente.');
  // TODO: implementar modal con formulario
}

cargarClientes();
