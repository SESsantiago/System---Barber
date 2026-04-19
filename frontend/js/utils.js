// utils.js — funciones reutilizables

function formatFecha(isoString) {
  if (!isoString) return '—';
  return new Date(isoString).toLocaleDateString('es-CO', {
    day: '2-digit', month: '2-digit', year: 'numeric'
  });
}

function formatMoneda(valor) {
  if (valor === null || valor === undefined) return '—';
  return new Intl.NumberFormat('es-CO', {
    style: 'currency', currency: 'COP', minimumFractionDigits: 0
  }).format(valor);
}

function mostrarAlerta(mensaje, tipo = 'info') {
  // tipo: 'info' | 'error' | 'success'
  alert(`[${tipo.toUpperCase()}] ${mensaje}`);
}
