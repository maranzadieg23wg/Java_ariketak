from selenium import webdriver
import time

web = webdriver.Chrome()
web.get("https://www.bataplandisco.com/tickets/#/es/event/bataplan-university-we-love-thursdays-1--143840")
time.sleep(5)

#entradas = web.find_element_by_xpath("/html/body/div[8]/div/div[3]/div/div/div/article/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/section/div/div")
entradas = web.find_element("xpath", "/html/body/div[8]/div/div[3]/div/div/div/article/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/section/div/div")
entradas.click()
time.sleep(5)

# Cantidad de entradas
cantidad = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[1]/div/div[2]/div/button[2]").click()
time.sleep(5)

jarraitu = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[2]/div[4]/div/div[2]").click()
time.sleep(5)

inputName = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[1]/input")
inputName.click()
inputName.send_keys("Manex")

inputSecondName = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[2]/input")
inputSecondName.click()
inputSecondName.send_keys("Aranzadi")

inputEmail = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[3]/input")
inputEmail.click()
inputEmail.send_keys("manexae@gmail.com")

inputEmail2 = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[4]/input")
inputEmail2.click()
inputEmail2.send_keys("manexae@gmail.com")

jarraitu2 = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[2]/div[4]/div/div[2]/button").click()
time.sleep(6)

# Tarjeta de crédito
zenbakia = web.find_element_by_xpath("/html/body/div/input")
zenbakia.click()
zenbakia.send_keys("12345")

# Fecha de caducidad de la tarjeta
data = web.find_element_by_xpath("/html/body/div/input")
data.click()
data.send_keys("0505")

# SVC
SVC = web.find_element_by_xpath("/html/body/div/input")
SVC.click()
SVC.send_keys("050")

# Nombre
izena = web.find_element_by_xpath("/html/body/div/input")
izena.click()
izena.send_keys("Proba J.")

jarraitu3 = web.find_element_by_xpath("/html/body/div[13]/div/div/div/div[2]/div[4]/div/div[2]/button").click()
