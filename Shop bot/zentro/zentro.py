from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import Select
import time


web = webdriver.Chrome()
web.get("https://ikasgunea.euskadi.eus/eu/buscador-de-centros")
time.sleep(2)


dropdown = driver.find_element_by_xpath('//*[@id="selectTerritorio"]')
select = Select(dropdown)
select.select_by_value('20')

time.sleep(200)
