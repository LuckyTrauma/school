all: submodule main

submodule:
		g++ -c ./common/mouseParGen/particles.cpp
		g++ -c  ./common/loadShaders/shader.cpp
		g++ -c ./common/callbacks/callBacks.cpp
		g++ -c ./math/math.cpp
		clear

main:
		g++ -o main main.cpp ./math/math.cpp ./common/mouseParGen/mouse.cpp shader.o callBacks.o particles.o -lglut -lGLEW -lglfw -lGLU -lGL -lpthread -lX11 -lrt
		clear


clean:
		rm particles.o
		rm shader.o
		rm callBacks.o
		rm math.o
		rm main
		clear

run:
		./main
monitor:
		wmctrl -r Test -e 0,0,0,3840,1080




		particles:
		g++ -c ./common/particles/particles.cpp


shader:
		g++ -c  ./common/loadShaders/shader.cpp

callbacks:
		g++ -c ./common/callbacks/callBacks.cpp
		
math:
		g++ -c ./math/math.cpp