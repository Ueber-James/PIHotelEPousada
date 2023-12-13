import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './adminPage.css';

function AdminPage() {
  const [productList, setProductList] = useState([]);
  const [newProduct, setNewProduct] = useState({
    name: '',
    description: '',
    price: 0,
  });

  useEffect(() => {
    fetchProductList();
  }, []);

  const fetchProductList = async () => {
    try {
      const response = await axios.get('http://localhost:3001/api/products');
      setProductList(response.data.products);
    } catch (error) {
      console.error('Erro ao buscar a lista de produtos:', error);
    }
  };

  const addProduct = async () => {
    try {
      const response = await axios.post('http://localhost:3001/api/products', newProduct);
      if (response.data.success) {
        fetchProductList();
        setNewProduct({
          name: '',
          description: '',
          price: 0,
        });
      }
    } catch (error) {
      console.error('Erro ao adicionar produto:', error);
    }
  };

  const removeProduct = async (productId) => {
    try {
      const response = await axios.delete(`http://localhost:3001/api/products/${productId}`);
      if (response.data.success) {
        fetchProductList();
      }
    } catch (error) {
      console.error('Erro ao remover produto:', error);
    }
  };

  return (
    <div>
      <h1>Administração</h1>

      <h2>Adicionar Novo Produto</h2>
      <form>
        <label htmlFor="productName">Nome do Produto:</label>
        <input
          type="text"
          id="productName"
          value={newProduct.name}
          onChange={(e) => setNewProduct({ ...newProduct, name: e.target.value })}
        />

        <label htmlFor="productDescription">Descrição:</label>
        <textarea
          id="productDescription"
          value={newProduct.description}
          onChange={(e) => setNewProduct({ ...newProduct, description: e.target.value })}
        />

        <label htmlFor="productPrice">Preço:</label>
        <input
          type="number"
          id="productPrice"
          value={newProduct.price}
          onChange={(e) => setNewProduct({ ...newProduct, price: e.target.value })}
        />

        <button type="button" onClick={addProduct}>
          Adicionar Produto
        </button>
      </form>

      <h2>Lista de Produtos</h2>
      <ul>
        {productList.map((product) => (
          <li key={product.id}>
            {product.name} - {product.price}{' '}
            <button type="button" onClick={() => removeProduct(product.id)}>
              Remover
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default AdminPage;
