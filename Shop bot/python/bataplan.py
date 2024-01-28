#from selenium import webdriver
import time


denbora =1

web = webdriver.Chrome()
web.get("https://www.bataplandisco.com/tickets/#/es/event/bataplan-university-we-love-thursdays-1--143840")
time.sleep(denbora+2)

#Honen bitartez ireki egiten da erosteko ticketak, berriro egin behar da bot-a
#document.getElementsByClassName('StyledContainer-sc-sdy56u-0 Box-sc-sdy56u-3 Card-sc-1gnzppj-0 cTlrYq kRjbYe ilqwYK')[0].click();
entradas = web.find_element("xpath", "/html/body/div[8]/div/div[3]/div/div/div/article/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/section/div/div")
entradas.click()
time.sleep(denbora)

# Cantidad de entradas
cantidad =web.find_element("xpath", "/html/body/div[13]/div/div/div/div[1]/div/div[2]/div/button[2]")
cantidad.click()
time.sleep(denbora)


jarraitu = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[2]/div[4]/div/div[2]")
jarraitu.click()
time.sleep(denbora)

inputName = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[1]/input")
inputName.click()
inputName.send_keys("Manex")

inputSecondName = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[2]/input")
inputSecondName.click()
inputSecondName.send_keys("Aranzadi")

inputEmail = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[3]/input")
inputEmail.click()
inputEmail.send_keys("manexae@gmail.com")

inputEmail2 = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[1]/div/div/div/form/div/div/div[4]/input")
inputEmail2.click()
inputEmail2.send_keys("manexae@gmail.com")

jarraitu2 = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[2]/div[4]/div/div[2]")
jarraitu2.click()
time.sleep(denbora+3)




time.sleep(260)

'''
#Fallatzen du zenbakiak beti aldatzen da
# Tarjeta de crédito

zenbakia = web.find_element("xpath", '//*[contains(@id="adyen-checkout-encryptedCardNumber")]')
zenbakia.click()
zenbakia.send_keys("12345")

# Fecha de caducidad de la tarjeta
data = web.find_element("xpath", '//*[contains(@id="adyen-checkout-encryptedExpiryDate")]')
data.click()
data.send_keys("0505")

# SVC
SVC = web.find_element("xpath", '//*[contains(@id="adyen-checkout-encryptedSecurityCode")]')
SVC.click()
SVC.send_keys("050")

# Nombre
izena = web.find_element("xpath", '//*[contains(@id="adyen-checkout-holderName")]')
izena.click()
izena.send_keys("Proba J.")

jarraitu3 = web.find_element("xpath", "/html/body/div[13]/div/div/div/div[2]/div[4]/div/div[2]")
jarraitu3.click()
'''
