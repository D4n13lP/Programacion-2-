// González Ayala Mauricio
// Pineda Ortega Daniel
#include <stdio.h>
#include <stdlib.h>

void getMatrix(int*** matrix, int* m, int* n) {
    printf("\n\tIngresa número de elementos de la fila: ");
    scanf("%d", m);
    printf("\n\tIngresa número de elementos de la columna: ");
    scanf("%d", n);

    *matrix = (int**)malloc(*m * sizeof(int*));
    for (int i = 0; i < *m; i++) {
        (*matrix)[i] = (int*)malloc(*n * sizeof(int));
        for (int j = 0; j < *n; j++) {
            printf("\n\tIngresa el valor para la posición [%d][%d]: ", i + 1, j + 1);
            scanf("%d", &((*matrix)[i][j]));
        }
    }
}

void deployMatrix(int** matrix, int m, int n) {
    printf("\n\tMatriz:\n");
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matrix[i][j]);
        }
        printf("\n");
    }
}

// Función que implementa la parte "Si": verifica si la matriz cumple la propiedad específica
int checkProperty(int** matrix, int m, int n) {
    for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
            if (matrix[i][j] + matrix[i + 1][j + 1] > matrix[i][j + 1] + matrix[i + 1][j]) {
                return 0;  // No cumple la propiedad
            }
        }
    }
    return 1;  // Cumple la propiedad
}

// Función que implementa la parte "Solo si": asume que la matriz es Monge y verifica la propiedad específica
int isMongeArray(int** matrix, int m, int n) {
    for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < n - 1; j++) {
            if (matrix[i][j] + matrix[i + 1][j + 1] > matrix[i][j + 1] + matrix[i + 1][j]) {
                return 0;  // La propiedad específica no se cumple, por lo tanto, no es Monge
            }
        }
    }
    return 1;  // La propiedad específica se cumple en todas las submatrices 2x2
}

int main() {
    int** matrix;
    int m, n;

    // Llama a getMatrix pasando la dirección de matrix y los punteros a m y n
    getMatrix(&matrix, &m, &n);

    // Despliega la matriz usando los valores de m y n
    deployMatrix(matrix, m, n);

    // Verifica si la matriz cumple la propiedad específica ("Si")
    if (checkProperty(matrix, m, n)) {
        printf("\n\tLa matriz cumple la propiedad específica de Monge (Parte 'Si').\n");
    } else {
        printf("\n\tLa matriz NO cumple la propiedad específica de Monge (Parte 'Si').\n");
    }

    // Verifica si la matriz es Monge en general ("Solo si")
    if (isMongeArray(matrix, m, n)) {
        printf("\n\tLa matriz cumple con la condición de ser Monge (Parte 'Solo si').\n");
    } else {
        printf("\n\tLa matriz NO cumple con la condición de ser Monge (Parte 'Solo si').\n");
    }

    // Libera la memoria asignada
    for (int i = 0; i < m; i++) {
        free(matrix[i]);
    }
    free(matrix);

    return 0;
}
