import App from './../App';

import { describe, it, expect, beforeAll,  } from 'vitest';
import {  render, screen } from '@testing-library/react';
import { Home } from '../pages/Home';

beforeAll(() => {
    render(<Home />);
})

describe('Renders main page correctly', () => {
it('should render the page correctly', () => {
    // Setup
    const button = screen.getByRole('button');

    // Expectations
    expect(button).not.toBeNull();
});
    
        it( 'should be able to add new item to the list ',() => {
            const { getByText, getByPlaceholderTest} = render (<App />)

            const inputElement = getByPlaceholderTest('novoItem')
            userEvent.type(inputElement,'novo');

            expect(getByText('novo').toBeInTheDocument())
        });
    });