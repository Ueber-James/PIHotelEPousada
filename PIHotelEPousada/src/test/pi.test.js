import { createApp } from 'vitest';
import { expect } from 'vitest';

// Importe o componente que você deseja testar
import App from '../App';

// Crie uma instância do aplicativo vitest
const app = createApp();

app.test('Renders main page correctly', () => {
  app.beforeAll(() => {
    // Renderize o componente que você deseja testar
    app.render(App);
  });

  app.it('should render the page correctly', () => {
    // Use os métodos do vitest para fazer as verificações
    const button = app.screen.getByRole('button');
    expect(button).not.toBeNull();
  });

  app.it('should be able to add a new item to the list', () => {
    const { getByText, getByPlaceholderText, userEvent } = app.render(App);

    const inputElement = getByPlaceholderText('novoItem');
    userEvent.type(inputElement, 'novo');

    expect(getByText('novo')).toBeInTheDocument();
  });
});

// Execute os testes
app.run();
