# rubiks-cube
Java program that brute force solves a rubik's cube 


# Example

```java
Cube cube = new Cube();
CubeHabdler handler = new CubeHandler(cube);

cube.printCube();
handler.bruteForceFront();
cube.printCube();
```


# API

### Cube

```java
Cube cube = new Cube();

cube.rotateX(0);
cube.rotateY(0);
cube.isSolved();
cube.printCube();
```

### CubeHandler

```java
CubeHandler handler = new CubeHandler(cube);

handler.mix();
handler.bruteForceFront();
handler.bruteForceFull();
```
