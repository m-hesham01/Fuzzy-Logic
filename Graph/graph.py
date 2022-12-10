# importing libraries
import matplotlib.pyplot as plt

# Initialise the subplot function using number of rows and columns

figure, axis = plt.subplots(3, 3)
axis[0, 0].plot([0,0,10,30],[0,1,1,0])
axis[0, 0].plot([10,30,40,60],[0,1,1,0])
axis[0, 0].plot([40,60,70,90],[0,1,1,0])
axis[0, 0].plot([70,90,100,100],[0,1,1,0])
axis[0, 0].set_title("proj_funding")
# axis[2,2].set_title("alooo")

# # For Cosine Function
# axis[0, 1].plot(X, Y2)
# axis[0, 1].set_title("Cosine Function")

# # For Tangent Function
# axis[1, 0].plot(X, Y3)
# axis[1, 0].set_title("Tangent Function")

# # For Tanh Function
# axis[1, 1].plot(X, Y4)
# axis[1, 1].set_title("Tanh Function")

# Combine all the operations and display
plt.show()
