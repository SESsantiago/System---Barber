// api.js — módulo central para llamadas al backend Spring Boot
const API_BASE = 'http://localhost:8080/api';

const api = {
  async get(endpoint) {
    const res = await fetch(`${API_BASE}/${endpoint}`);
    if (!res.ok) throw new Error(`Error GET /${endpoint}: ${res.status}`);
    return res.json();
  },

  async post(endpoint, body) {
    const res = await fetch(`${API_BASE}/${endpoint}`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body)
    });
    if (!res.ok) throw new Error(`Error POST /${endpoint}: ${res.status}`);
    return res.json();
  },

  async put(endpoint, id, body) {
    const res = await fetch(`${API_BASE}/${endpoint}/${id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(body)
    });
    if (!res.ok) throw new Error(`Error PUT /${endpoint}/${id}: ${res.status}`);
    return res.json();
  },

  async delete(endpoint, id) {
    const res = await fetch(`${API_BASE}/${endpoint}/${id}`, { method: 'DELETE' });
    if (!res.ok) throw new Error(`Error DELETE /${endpoint}/${id}: ${res.status}`);
  }
};
